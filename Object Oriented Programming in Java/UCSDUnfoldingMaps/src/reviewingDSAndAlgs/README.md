As mentioned in commenting lines of the code in this directory, when we are using the java's built-in sort algorithm for non integers the algorithm will not know how to make the comparisons since its no longer an integer. Therefore, we need to implement the **Comparable** interface. By using this interface we will implement the `compareTo()` method which will store the code to let java's sorting algorithm understand how to perform comparisons between elements. The `compareTo()` method will return an integer number which will be the result of the comparison between the calling object and the parameter sent to its `compreTo()` function.

A good mnemonic to remember how the `compareTo()` method works is by simply imagine that we are subtracting the number on the left with the one on the right:


![alt text][logo]

[logo]: https://github.com/Jplaudir8/OOP-in-Java/blob/master/Object%20Oriented%20Programming%20in%20Java/UCSDUnfoldingMaps/src/reviewingDSAndAlgs/Table%201.png "Table extracted from coursera video"


<img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Object%20Oriented%20Programming%20in%20Java/UCSDUnfoldingMaps/src/reviewingDSAndAlgs/Table%201.png" height="48" alt="Table extracted from coursera video">