package kr.dogfoot.hwplib.util.compoundFile.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import kr.dogfoot.hwplib.object.fileheader.FileVersion;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class CompoundFileWriter {
	private POIFSFileSystem fs;
	private DirectoryEntry currentStorage;
	private StreamWriter currentStreamWriter;

	public CompoundFileWriter() {
		fs = new POIFSFileSystem();
		currentStorage = fs.getRoot(); 
	}
	
	public void write(String filepath) throws IOException {
		OutputStream os = new FileOutputStream(filepath);
		fs.writeFilesystem(os);
		os.close();
	}

	public void close() throws IOException {
		fs.close();
	}
	
	public void openCurrentStorage(String name) throws IOException {
		currentStorage = currentStorage.createDirectory(name);
	}
	
	public void closeCurrentStorage() {
		currentStorage = currentStorage.getParent();
	}
	
	public StreamWriter openCurrentStream(String name, boolean compress, FileVersion fileVersion) {
		currentStreamWriter = new StreamWriter(name, compress, fileVersion);
		return currentStreamWriter;
	}
	
	public void closeCurrentStream() throws IOException {
		InputStream is = currentStreamWriter.getDataStream();
		currentStorage.createDocument(currentStreamWriter.getName(), is);
		is.close();
		currentStreamWriter.close();
		currentStreamWriter = null;
	}

    public void gotoRootStorage() {
        currentStorage = fs.getRoot();
    }
}
