# Benchmarking
Comparing running time execution between BasicDocument.java and EfficientDocument.java. This comparison is measured by giving each of them a String of characters as their input:
(Expressed in seconds)
|Number of Chars|BasicDocument  |EfficientDocument|
|:-------------:|:-------------:|:---------------:|
|50000	        |0.318748415	|0.168371265      |
|70000	        |0.329913168	|0.198769718      |
|90000	        |0.425220374	|0.255722984      |
|110000	        |0.521454468	|0.312093584      |
|130000	        |0.618784501	|0.37073883       |
|150000	        |0.710506159	|0.429541017      |
|170000	        |0.809404733    |0.485948675      |
|190000	        |0.906787203    |0.54738703       |
|210000	        |1.001365732    |0.598654524      |
|230000	        |1.102600776	|0.64676726       |
|250000	        |1.198988598    |0.706533647      |
|270000	        |1.293270952    |0.764579129      |
|290000	        |1.400228802    |0.81746627       |
|310000	        |1.492233943    |0.869635927      |
|330000	        |1.595472193    |0.931921291      |
|350000	        |1.700980528	|1.023571764      |
|370000	        |1.940399098    |1.11699351       |
|390000	        |2.085557462    |1.38440641       |
|410000	        |2.079988539    |1.187757438      |
|430000	        |2.145824455    |1.244435679      |

# Images

Plotting the Data:

<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Data%20Structures%20and%20Performance/TextEditor/src/document/Stats1.png" height="420" alt="graphic1" title="graphic1">
</p>
<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Data%20Structures%20and%20Performance/TextEditor/src/document/Stats2.png" height="420" alt="graphic2" title="graphic2">
</p>
<p align="center">
    <img src="https://github.com/Jplaudir8/OOP-in-Java/blob/master/Data%20Structures%20and%20Performance/TextEditor/src/document/Stats3.png" height="420" alt="graphic3" title="graphic3">
</p>

We can conclude that our running time complexity is better in our EfficientDocument, since its tightest Big-O running time would be leaning to O(n), a linear growth in terms of time.