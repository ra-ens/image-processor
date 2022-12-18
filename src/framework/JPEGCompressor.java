package framework;

public class JPEGCompressor extends ImageProcessor{
    @Override
    protected void initCompress() {
        System.out.println("Init Compressor");
    }

    @Override
    protected int[] performCompression(int[] data) {
        System.out.println("Compressing...");
        return data;
    }

    @Override
    protected void afterCompress() {
        System.out.println("After compressing");
    }
}
