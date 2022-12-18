# Image Processing Project

This project aims to provide an image processing framework that allows applying treatments on an image represented as an array of integers.
the project use different design patterns to provide a flexible interface, the user can choose the filter strategy he want. 
And a parts of the compressor algorithm can be defined by the user

## Features
The framework defines the following operations:

- `filter(int[] data)`: this method allows filtering the image.
- `compress(int[] data)`: this method allows compressing the image.
- `filterProxy`: this proxy allows applying a non-standard filter to the image like `applyFilter(String filterName, int[] data)`.

## Usage
To use the framework, you can create subclasses that extend the `ImageProcessor` class and implement the compression operations in a specific way. when usign you implementation you can set a filter to use.
You can also define you filters by implementing the `IImageFilter` interface.

Here is an example of code showing how to use the framework:

```java
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
```

```java
public class JPEGFilter implements IImageFilter {
    @Override
    public int[] filter(int[] data) {
        // filter treatment
        return data;
    }
}
```

```java
ImageProcessor imageProcessor = new JPEGCompressor();
IImageFilter filter = new JPEGFilter();
imageProcessor.setImageFilter(filter);

// We retrieve the image to be processed in the form of an array of integers
int[] imageData = this.getImageData();

int[] filteredData = imageProcessor.filter(imageData);

// Compress the image
int[] compressedData = imageProcessor.compress(filteredData);

// Save the compressed image
this.saveCompressedImage(compressedData);
```

## License
This project is licensed under the MIT License
