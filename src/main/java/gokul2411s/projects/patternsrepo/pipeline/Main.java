package gokul2411s.projects.patternsrepo.pipeline;

import com.google.common.collect.ImmutableList;
import gokul2411s.projects.patternsrepo.events.*;
import gokul2411s.projects.patternsrepo.transformation.Transformer;
import gokul2411s.projects.patternsrepo.transformation.Transformers;

import java.io.*;

/**
 * Sample pipeline.
 */
class Main {

  public static void main(String[] args) throws IOException {

    // The pipeline is as follows.
    //     A
    //     |-------
    //     |      |
    //     B      C
    //     |      |
    //     |-------
    //     D
    //
    // The input is read by A.
    // A concatenates the input to itself.
    // A passes on the transformed values to B and C.
    // B lower-cases its input and then passes on to D.
    // C upper-cases its input, wraps it with quotes and then passes on to D.
    // D merely prints the output.

    // Set up D first.
    PrintWriter outputWriter = new PrintWriter(System.out);
    EventSource<WorkUnit> eventSourceDelegateForD =
        EventSources.printingEventSourceImpl(outputWriter);
    Transformer<WorkUnit> transformerForD = Transformers.noopTransformerImpl();
    EventProcessor<WorkUnit> processorForD =
        createProcessor(transformerForD, eventSourceDelegateForD);

    // Setup C (by wiring to D).
    EventSource<WorkUnit> eventSourceDelegateForC = createWithDownstreamObservers(processorForD);
    Transformer<WorkUnit> transformerForC =
        Transformers.getDecoratedTransformer(
            new UppercasingTransformerImpl(),
            new QuotingTransformerImpl());
    EventProcessor<WorkUnit> processorForC =
        createProcessor(transformerForC, eventSourceDelegateForC);

    // Setup B (by wiring to D).
    EventSource<WorkUnit> eventSourceDelegateForB = createWithDownstreamObservers(processorForD);
    Transformer<WorkUnit> transformerForB = new LowercasingTransformerImpl();
    EventProcessor<WorkUnit> processorForB =
        createProcessor(transformerForB, eventSourceDelegateForB);

    // Setup A (by wiring to both B and C).
    EventSource<WorkUnit> eventSourceDelegateForA =
        createWithDownstreamObservers(processorForB, processorForC);
    Transformer<WorkUnit> transformerForA = new SelfConcatTransformerImpl();
    EventProcessor<WorkUnit> processorForA =
        createProcessor(transformerForA, eventSourceDelegateForA);

    // Read inputs and pass through pipeline (by asking A to react).
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String line;
      while ((line = br.readLine()) != null) {
        processorForA.react(new WorkUnit(line));
      }
    }
  }

  private static EventSource<WorkUnit> createWithDownstreamObservers(
      EventObserver<WorkUnit>... downstreamObservers) {
    return EventSources.fixedObserversEventSourceImpl(ImmutableList.copyOf(downstreamObservers));
  }

  private static EventProcessor<WorkUnit> createProcessor(
      Transformer<WorkUnit> transformer, EventSource<WorkUnit> eventSourceDelegate) {
    return EventProcessors.immediatePassThroughProcessorImpl(transformer, eventSourceDelegate);
  }
}
