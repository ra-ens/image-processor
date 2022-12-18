package framework;

import filter.IImageFilter;

public abstract class ImageProcessor implements IImageProcessor {

    IImageFilter imageFilter;

    @Override
    public int[] filter(int[] data) {
        if(imageFilter == null) throw new RuntimeException("Image filter not initialized");
        return imageFilter.filter(data);
    }

    @Override
    public int[] compress(int[] data) {
        this.initCompress();
        int[] compressedData = this.performCompression(data);
        this.afterCompress();
        return compressedData;
    }

    protected abstract void initCompress();
    protected abstract int[] performCompression(int[] data);
    protected abstract void afterCompress();

    public void setImageFilter(IImageFilter imageFilter) {
        this.imageFilter = imageFilter;
    }
}
