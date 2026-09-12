package net.lingala.zip4j.tasks;

import com.taobao.weex.el.parse.Operators;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;

/* JADX INFO: loaded from: classes2.dex */
public class MergeSplitZipFileTask extends AsyncZipTask<MergeSplitZipFileTaskParameters> {
    private final RawIO rawIO;
    private final ZipModel zipModel;

    public MergeSplitZipFileTask(ZipModel zipModel, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.rawIO = new RawIO();
        this.zipModel = zipModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Bottom block not found for handler: all -> 0x00b7 */
    /* JADX WARN: Code duplicated, block: B:102:? A[Catch: all -> 0x00b7, SYNTHETIC, TRY_LEAVE, TryCatch #7 {, blocks: (B:32:0x009a, B:46:0x00b6, B:45:0x00b3, B:42:0x00ae), top: B:89:0x009a, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void executeTask(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters, ProgressMonitor progressMonitor) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        RandomAccessFile randomAccessFile;
        Throwable th2;
        int i;
        int i2;
        if (!this.zipModel.isSplitArchive()) {
            ZipException zipException = new ZipException("archive not a split zip file");
            progressMonitor.endProgressMonitor(zipException);
            throw zipException;
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(mergeSplitZipFileTaskParameters.outputZipFile);
            try {
                int numberOfThisDisk = this.zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk();
                if (numberOfThisDisk <= 0) {
                    throw new ZipException("zip archive not a split zip file");
                }
                long j = 0;
                int i3 = 0;
                int i4 = 0;
                while (i3 <= numberOfThisDisk) {
                    try {
                        RandomAccessFile randomAccessFileCreateSplitZipFileStream = createSplitZipFileStream(this.zipModel, i3);
                        try {
                            long length = randomAccessFileCreateSplitZipFileStream.length();
                            if (i3 == 0) {
                                try {
                                    if (this.rawIO.readIntLittleEndian(randomAccessFileCreateSplitZipFileStream) == HeaderSignature.SPLIT_ZIP.getValue()) {
                                        i = 4;
                                        i2 = 4;
                                    } else {
                                        randomAccessFileCreateSplitZipFileStream.seek(0L);
                                        i2 = i4;
                                        i = 0;
                                    }
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    fileOutputStream = fileOutputStream2;
                                    randomAccessFile = randomAccessFileCreateSplitZipFileStream;
                                    if (randomAccessFile != null) {
                                        throw th2;
                                    }
                                    try {
                                        randomAccessFile.close();
                                        throw th2;
                                    } catch (Throwable th4) {
                                        th2.addSuppressed(th4);
                                        throw th2;
                                    }
                                }
                            } else {
                                i2 = i4;
                                i = 0;
                            }
                            if (i3 == numberOfThisDisk) {
                                length = this.zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
                            }
                            long j2 = length;
                            long j3 = i;
                            try {
                                FileUtils.copyFile(randomAccessFileCreateSplitZipFileStream, fileOutputStream2, j3, j2, progressMonitor, mergeSplitZipFileTaskParameters.zip4jConfig.getBufferSize());
                                randomAccessFile = randomAccessFileCreateSplitZipFileStream;
                                fileOutputStream = fileOutputStream2;
                                j += j2 - j3;
                                try {
                                    int i5 = i3;
                                    int i6 = i2;
                                    updateFileHeaderOffsetsForIndex(this.zipModel.getCentralDirectory().getFileHeaders(), i3 == 0 ? 0L : j, i5, i6);
                                    verifyIfTaskIsCancelled();
                                    if (randomAccessFile != null) {
                                        randomAccessFile.close();
                                    }
                                    i3 = i5 + 1;
                                    i4 = i6;
                                    fileOutputStream2 = fileOutputStream;
                                } catch (Throwable th5) {
                                    th = th5;
                                    th2 = th;
                                    if (randomAccessFile != null) {
                                        throw th2;
                                    }
                                    randomAccessFile.close();
                                    throw th2;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                randomAccessFile = randomAccessFileCreateSplitZipFileStream;
                                fileOutputStream = fileOutputStream2;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            fileOutputStream = fileOutputStream2;
                            randomAccessFile = randomAccessFileCreateSplitZipFileStream;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        th = th;
                        try {
                            fileOutputStream2.close();
                            throw th;
                        } catch (Throwable th9) {
                            th.addSuppressed(th9);
                            throw th;
                        }
                    }
                }
                FileOutputStream fileOutputStream3 = fileOutputStream2;
                try {
                    try {
                        updateHeadersForMergeSplitFileAction(this.zipModel, j, fileOutputStream3, mergeSplitZipFileTaskParameters.zip4jConfig.getCharset());
                        progressMonitor.endProgressMonitor();
                        fileOutputStream3.close();
                    } catch (Throwable th10) {
                        th = th10;
                        fileOutputStream2 = fileOutputStream3;
                        th = th;
                        fileOutputStream2.close();
                        throw th;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    fileOutputStream2 = fileOutputStream3;
                }
            } catch (Throwable th12) {
                th = th12;
            }
        } catch (CloneNotSupportedException e) {
            throw new ZipException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters) {
        long length = 0;
        if (!this.zipModel.isSplitArchive()) {
            return 0L;
        }
        for (int i = 0; i <= this.zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk(); i++) {
            length += getNextSplitZipFile(this.zipModel, i).length();
        }
        return length;
    }

    private void updateFileHeaderOffsetsForIndex(List<FileHeader> list, long j, int i, int i2) {
        for (FileHeader fileHeader : list) {
            if (fileHeader.getDiskNumberStart() == i) {
                fileHeader.setOffsetLocalHeader((fileHeader.getOffsetLocalHeader() + j) - ((long) i2));
                fileHeader.setDiskNumberStart(0);
            }
        }
    }

    private File getNextSplitZipFile(ZipModel zipModel, int i) {
        String str;
        if (i == zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) {
            return zipModel.getZipFile();
        }
        if (i < 9) {
            str = ".z0";
        } else {
            str = ".z";
        }
        return new File(zipModel.getZipFile().getPath().substring(0, zipModel.getZipFile().getPath().lastIndexOf(Operators.DOT_STR)) + str + (i + 1));
    }

    private RandomAccessFile createSplitZipFileStream(ZipModel zipModel, int i) throws FileNotFoundException {
        return new RandomAccessFile(getNextSplitZipFile(zipModel, i), RandomAccessFileMode.READ.getValue());
    }

    private void updateHeadersForMergeSplitFileAction(ZipModel zipModel, long j, OutputStream outputStream, Charset charset) throws Throwable {
        ZipModel zipModel2 = (ZipModel) zipModel.clone();
        zipModel2.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(j);
        updateSplitZipModel(zipModel2, j);
        new HeaderWriter().finalizeZipFileWithoutValidations(zipModel2, outputStream, charset);
    }

    private void updateSplitZipModel(ZipModel zipModel, long j) {
        zipModel.setSplitArchive(false);
        updateSplitEndCentralDirectory(zipModel);
        if (zipModel.isZip64Format()) {
            updateSplitZip64EndCentralDirLocator(zipModel, j);
            updateSplitZip64EndCentralDirRec(zipModel, j);
        }
    }

    private void updateSplitEndCentralDirectory(ZipModel zipModel) {
        int size = zipModel.getCentralDirectory().getFileHeaders().size();
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(0);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(size);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(size);
    }

    private void updateSplitZip64EndCentralDirLocator(ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
            return;
        }
        Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = zipModel.getZip64EndOfCentralDirectoryLocator();
        zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
        zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryLocator.getOffsetZip64EndOfCentralDirectoryRecord() + j);
        zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(1);
    }

    private void updateSplitZip64EndCentralDirRec(ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
            return;
        }
        Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = zipModel.getZip64EndOfCentralDirectoryRecord();
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(0);
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory());
        zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(zip64EndOfCentralDirectoryRecord.getOffsetStartCentralDirectoryWRTStartDiskNumber() + j);
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.MERGE_ZIP_FILES;
    }

    public static class MergeSplitZipFileTaskParameters extends AbstractZipTaskParameters {
        private File outputZipFile;

        public MergeSplitZipFileTaskParameters(File file, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputZipFile = file;
        }
    }
}
