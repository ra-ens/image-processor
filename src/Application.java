import filter.IImageFilter;
import framework.IImageProcessor;
import framework.ImageProcessor;
import framework.JPEGCompressor;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de la classe d'implémentation de filtrage à utiliser: ");
        String filterClassName = scanner.nextLine();

        IImageFilter filter = this.instantiateClass(filterClassName);

        ImageProcessor imageProcessor = new JPEGCompressor();
        imageProcessor.setImageFilter(filter);

        // We retrieve the image to be processed in the form of an array of integers
        int[] imageData = this.getImageData();

        int[] filteredData = imageProcessor.filter(imageData);

        // Compress the image
        int[] compressedData = imageProcessor.compress(filteredData);

        // Save the compressed image
        this.saveCompressedImage(compressedData);
    }

    private IImageFilter instantiateClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return (IImageFilter) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int[] getImageData() {
        int[] data = {1,2,3,4,5,6,7};
        return data;
    }

    private void saveCompressedImage(int[] data) {
        System.out.print("Saved image: { ");
        for(int i=0; i<data.length; i++)
            System.out.print(data[i] + " ");
        System.out.println("}");
    }
}
