package filter;

public class ImageFilterProxy implements IImageFilter {

    private AncienneFilter ancienneFilter;

    public ImageFilterProxy(AncienneFilter ancienneFilter) {
        this.ancienneFilter = ancienneFilter;
    }

    @Override
    public int[] filter(int[] data) {
        return this.ancienneFilter.aplyFilter("ancien filter", data);
    }
}
