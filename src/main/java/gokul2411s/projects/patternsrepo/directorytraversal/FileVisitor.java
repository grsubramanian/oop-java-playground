package gokul2411s.projects.patternsrepo.directorytraversal;

/**
 * Represents a visitor on {@link File}.
 */
interface FileVisitor {

  void visit(SymlinkFileImpl symlinkFile);

  void visit(RegularFileImpl regularFile);

  void visit(RegularDirectoryImpl regularDirectory);
}
