package util;

import org.apache.log4j.RollingFileAppender;

import java.io.*;

public class MyRollingFileAppender extends RollingFileAppender {

    @Override
    public synchronized void setFile(String file, boolean append, boolean bufferedIO, int bufferSize)
            throws IOException {
        if(bufferedIO){
            setImmediateFlush(false);
        }
        reset();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file, append);
        }catch (FileNotFoundException error){
            String parent = new File(file).getParent();
            if(parent!=null){
                File parentDir = new File(parent);
                if(!parentDir.exists() && parentDir.mkdirs()){
                    outputStream = new FileOutputStream(file, append);
                }else {
                    throw  error;
                }
            }else{
                throw error;
            }
        }
        Writer writer = createWriter(outputStream);
        if(bufferedIO){
            writer = new BufferedWriter(writer, bufferSize);
        }
        this.setQWForFiles(writer);
        this.fileName = file;
        this.fileAppend = append;
        this.bufferedIO = bufferedIO;
        this.bufferSize = bufferSize;
        writeHeader();
    }
}
