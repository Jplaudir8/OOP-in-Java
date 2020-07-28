# Benchmarking
Comparing running time execution between DictionaryLL.java and DictionaryBST.java. This comparison is measured by giving each of them a String of characters that is not a word so that we make both classes iterate thwough the entire data structure, time is expressed in seconds:
|Number of Chars|DictionaryLL  |DictionaryBST|
|:-------------:|:-------------:|:---------------:|
|     50000	    |   133146549	|      91999      |
|     52000	    |   133408249	|      62301      |
|     54000	    |   137914967	|      44550      |
|     56000	    |   142562172	|      47895      |
|     58000	    |   150012742	|      44944      |
|     60000	    |   150558669	|      45772      |
|     62000	    |   164019872	|      44044      |
|     64000	    |   188115236	|      47955      |
|     66000	    |   168399841	|      48445      |
|     68000	    |   193634591	|      57481      |
|     70000	    |   189258313	|      57199      |
|     72000	    |   252905152	|      87253      |
|     74000	    |   191038966	|      59840      |
|     76000	    |   228703066	|      49277      |
|     78000	    |   236518716	|      48956      |
|     80000	    |   229399930	|      47733      |
|     82000	    |   213070104	|      46227      |
|     84000	    |   219553644	|      45375      |
|     86000	    |   236564782	|      46938      |
|     88000	    |   244258029	|      46583      |

# Images

Plotting the Data:

<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Data%20Structures%20and%20Performance/TextEditor/src/spelling/Stats1.png" height="400" alt="graphic1" title="graphic1">
</p>
<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Data%20Structures%20and%20Performance/TextEditor/src/spelling/Stats2.png" height="400" alt="graphic2" title="graphic2">
</p>
<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Data%20Structures%20and%20Performance/TextEditor/src/spelling/Stats3.png" height="400" alt="graphic3" title="graphic3">
</p>

We can conclude that our running time complexity is better in our DictionaryBST class which imlements a Balanced Binary Search Tree.