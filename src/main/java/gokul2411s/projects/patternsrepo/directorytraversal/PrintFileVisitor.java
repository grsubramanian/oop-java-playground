package gokul2411s.projects.patternsrepo.directorytraversal;

import java.io.PrintWriter;

/**
 * A simple {@link FileVisitor} which prints important info about files that it visits.
 */
class PrintFileVisitor implements FileVisitor {

  private final PrintWriter printWriter;

  PrintFileVisitor(PrintWriter printWriter) {
    this.printWriter = printWriter;
  }

  @Override
  public void visit(SymlinkFileImpl symlinkFile) {
    printWriter.append(
        String.format(
            "[%s] symlink to [%s]\n", symlinkFile.getPath(), symlinkFile.getTarget().getPath()));
    printWriter.flush();
  }

  @Override
  public void visit(RegularFileImpl regularFile) {
    printWriter.append(
        String.format(
            "[%s] file at [%d] millis since epoch\n",
            regularFile.getPath(),
            regularFile.getCreationTimestamp().getMillis()));
    printWriter.flush();
  }

  @Override
  public void visit(RegularDirectoryImpl regularDirectory) {
    printWriter.append(
        String.format(
            "[%s] directory at [%d] millis since epoch\n",
            regularDirectory.getPath(),
            regularDirectory.getCreationTimestamp().getMillis()));
    printWriter.flush();
  }
}
