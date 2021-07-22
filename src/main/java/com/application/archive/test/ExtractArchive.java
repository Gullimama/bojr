package com.application.archive.test;

import java.io.File;
import java.io.IOException;

import com.application.archive.ArchiveFormat;
import com.application.archive.Archiver;
import com.application.archive.ArchiverFactory;

public class ExtractArchive {

	public static void main(String[] args) {
		File archive = new File("test.zip");
		File destination = new File("/testZipExtracted");

		Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
		try {
			archiver.extract(archive, destination);
			System.out.println("Done.");
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
}
