package com.application.archive;

import static com.application.archive.ArchiveFormat.AR;
import static com.application.archive.ArchiveFormat.CPIO;
import static com.application.archive.ArchiveFormat.DUMP;
import static com.application.archive.ArchiveFormat.JAR;
import static com.application.archive.ArchiveFormat.SEVEN_Z;
import static com.application.archive.ArchiveFormat.TAR;
import static com.application.archive.ArchiveFormat.ZIP;
import static com.application.archive.CompressionType.BZIP2;
import static com.application.archive.CompressionType.GZIP;
import static com.application.archive.CompressionType.PACK200;
import static com.application.archive.CompressionType.XZ;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Holds the file extension as String and the corresponding {@link ArchiveFormat} and/or {@link CompressionType}.
 */
public final class FileType {

    private static final Map<String, FileType> MAP = new LinkedHashMap<String, FileType>();

    /**
     * Special case object for an unknown archive/compression file type.
     */
    public static final FileType UNKNOWN = new FileType("", null, null);

    static {
        // compressed archives
        add(".tar.gz", TAR, GZIP);
        add(".tgz", TAR, GZIP);
        add(".tar.bz2", TAR, BZIP2);
        add(".tbz2", TAR, BZIP2);
        // archive formats
        add(".7z", SEVEN_Z);
        add(".a", AR);
        add(".ar", AR);
        add(".cpio", CPIO);
        add(".dump", DUMP);
        add(".jar", JAR);
        add(".tar", TAR);
        add(".zip", ZIP);
        add(".zipx", ZIP);
        // compression formats
        add(".bz2", BZIP2);
        add(".xz", XZ);
        add(".gzip", GZIP);
        add(".gz", GZIP);
        add(".pack", PACK200);
    }

    private final String suffix;
    private final ArchiveFormat archiveFormat;
    private final CompressionType compression;

    private FileType(String suffix, ArchiveFormat archiveFormat) {
        this(suffix, archiveFormat, null);
    }

    private FileType(String suffix, CompressionType compression) {
        this(suffix, null, compression);
    }

    private FileType(String suffix, ArchiveFormat archiveFormat, CompressionType compression) {
        this.suffix = suffix;
        this.compression = compression;
        this.archiveFormat = archiveFormat;
    }

    /**
     * Returns true if the given file extension denotes an archive.
     * 
     * @return true if file extension is an archive, false otherwise
     */
    public boolean isArchive() {
        return archiveFormat != null;
    }

    /**
     * Returns true if the given file extension denotes a compressed file.
     * 
     * @return true if file extension is a compressed type, false otherwise
     */
    public boolean isCompressed() {
        return compression != null;
    }

    /**
     * Returns the file extension suffix (e.g. ".zip" or ".tar.gz").
     * 
     * @return the file extension suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Returns the archive format corresponding to this file extension if any.
     * 
     * @return the archive format or null if the file extension does not denote an archive
     */
    public ArchiveFormat getArchiveFormat() {
        return archiveFormat;
    }

    /**
     * Returns the compression type corresponding to this file extension if any.
     * 
     * @return the compression type or null if the file extension does not denote a compressed file
     */
    public CompressionType getCompressionType() {
        return compression;
    }

    @Override
    public String toString() {
        return getSuffix();
    }

    /**
     * Checks the suffix of the given string for an entry in the map. If it exists, the corresponding {@link FileType}
     * entry will be returned.
     * 
     * @param filename the filename to check
     * @return a {@link FileType} entry for the file extension of the given name, or the UNKNOWN type if it does not
     *         exist
     */
    public static FileType get(String filename) {
        for (Map.Entry<String, FileType> entry : MAP.entrySet()) {
            if (filename.toLowerCase().endsWith(entry.getKey())) {
                return entry.getValue();
            }
        }

        return UNKNOWN;
    }

    /**
     * Checks the suffix of the given {@link File} for an entry in the map. If it exists, the corresponding
     * {@link FileType} entry will be returned.
     * 
     * @param file the file to check
     * @return a {@link FileType} entry for the file extension of the given file, or the UNKNOWN type if it does not
     *         exist
     */
    public static FileType get(File file) {
        return get(file.getName());
    }

    private static void add(String suffix, ArchiveFormat archiveFormat) {
        MAP.put(suffix, new FileType(suffix, archiveFormat));
    }

    private static void add(String suffix, CompressionType compressionType) {
        MAP.put(suffix, new FileType(suffix, compressionType));
    }

    private static void add(String suffix, ArchiveFormat archiveFormat, CompressionType compressionType) {
        MAP.put(suffix, new FileType(suffix, archiveFormat, compressionType));
    }

}
