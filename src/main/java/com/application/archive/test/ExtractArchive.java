package com.application.archive.test;

import java.io.File;
import java.io.IOException;

import com.application.archive.ArchiveFormat;
import com.application.archive.Archiver;
import com.application.archive.ArchiverFactory;

public class ExtractArchive {

	public static void main(String[] args) {
		
		if ( args.length != 2 ) {
			throw new IllegalArgumentException("Needs to have 2 arguments. The first refers to the source zip file, the second refers to the destination folder");
		}
		
		String sourceFile = args[0];
		String destinationFolder = args[1];
		
		File archive = new File( sourceFile );
		File destination = new File( destinationFolder );

		Archiver archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
		try {
			archiver.extract(archive, destination);
			System.out.println("Done.");
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
}
