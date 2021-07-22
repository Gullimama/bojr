package com.application.archive.test;

import java.io.File;
import java.io.IOException;

import com.application.archive.Archiver;
import com.application.archive.ArchiverFactory;

public class CreateArchive {

	public static void main(String[] args) {
		String archiveName = "folder5";
		File destination = new File("c:/Users/ozget");
		// File destination = new File("c:/testdir/folder5");
		File source = new File("c:/testdir/folder5");

		Archiver archiver = ArchiverFactory.createArchiver("zip");
		try {
			File archive = archiver.create(archiveName, destination, source);
			System.out.println("Done.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
