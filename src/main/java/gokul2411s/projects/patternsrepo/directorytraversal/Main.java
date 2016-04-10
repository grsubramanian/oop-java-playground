package gokul2411s.projects.patternsrepo.directorytraversal;

import org.joda.time.Instant;

import java.io.PrintWriter;

/**
 * A sample traversal on a filesystem using a printing visitor.
 */
class Main {

  public static void main(String[] args) {

    // Create a sample directory structure as follows.
    //
    // /root
    // |
    // --- usr
    // |    |
    // |    --- testfile (regular file)
    // |
    // --- var
    //      |
    //      --- testfile_cpy (symlink to /usr/testfile)

    Directory root = new RegularDirectoryImpl("root", Instant.now());
    Directory usr = new RegularDirectoryImpl("usr", Instant.now());
    Directory var = new RegularDirectoryImpl("var", Instant.now());

    root.addFile(usr);
    root.addFile(var);

    File file1 = new RegularFileImpl("testfile", Instant.now());
    File file2 = new SymlinkFileImpl("testfile_cpy", Instant.now(), file1);
    usr.addFile(file1);
    var.addFile(file2);

    // Allow a visitor to access the filesystem.
    FileVisitor fileVisitor = new PrintFileVisitor(new PrintWriter(System.out));
    root.allow(fileVisitor);
  }
}
