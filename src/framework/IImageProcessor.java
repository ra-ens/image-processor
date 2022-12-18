package framework;

public interface IImageProcessor {
    int[] filter(int[] data);
    int[] compress(int[] data);
}
