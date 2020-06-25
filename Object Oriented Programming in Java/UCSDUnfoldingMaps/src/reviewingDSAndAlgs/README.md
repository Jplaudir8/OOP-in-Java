### Using java's built-in merge-sort algorithm.

As mentioned in commenting lines of the code in this directory, when we are using the java's built-in `Collection.sort()` algorithm for non integers the algorithm will not know how to make the comparisons since its no longer an integer. Therefore, we need to implement the **Comparable** interface. By using this interface we will implement the `compareTo()` method which will store the code to let java's sorting algorithm understand how to perform comparisons between elements. The `compareTo()` method will return an integer number which will be the result of the comparison between the calling object and the parameter sent to its `compreTo()` function.

A good mnemonic to remember how the `compareTo()` method works is by simply imagine that we are subtracting the number on the left with the one on the right:

<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Object%20Oriented%20Programming%20in%20Java/UCSDUnfoldingMaps/src/reviewingDSAndAlgs/Table%201.png" height="110" alt="Image extracted from coursera video" title="Table extracted from coursera video">
</p>

In order to illustrate this scenario in a better way, let's think of the following array and the class **Airport**:

<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Object%20Oriented%20Programming%20in%20Java/UCSDUnfoldingMaps/src/reviewingDSAndAlgs/ArrayIMG.png" height="110" alt="Image extracted from coursera video" title="Table extracted from coursera video">
</p>

``` java
public class Airport {
    private String city;
    private String country;
    private String code3;
    ...

    public String getCity() { return this.city; }
    public String getCountry() { return this.city; }
    public String getCode() { return this.city; }
    ...

    public static void main (String[] args){
        ArrayList<Airport> airports = new ArrayList();
        ...
        airports.add( ... );
        ...
        // This line below will result in an error since sort() won't be able to compare objects.
        Collections.sort(airports);
    }
}
```

#### The solution (implementing Comparable interface):

``` java
public class Airport implements Comparable<Airport>{
    
    ...
    
    // Method coming from Comparable interface.
    public int compareTo (Airport other){
        // Using compareTo method for String objects. Comparing based on the city.
        return (this.getCity().compareTo(other.getCity()));
    }

    public static void main (String[] args){
        ArrayList<Airport> airports = new ArrayList();
        ...
        airports.add( ... );
        ...
        // This will workout now! :)
        Collections.sort(airports);
    }
}
```