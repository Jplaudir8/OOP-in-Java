# Description of the Project 🧰

The project for this course is to build a smart text editor/processor that incorporates “intelligent” behaviors of modern-day text interfaces including autocomplete, flagging misspelled words and spelling auto-correct.

In order to develop this test editor application, I will focus on some basic fundamental data structures including linked lists and trees, and go on to touch on more advanced structures like hashsets, linked lists and tries. And front and center throughout this project will be the subject of code and algorithm efficiency and correctness.

Being more specific and with help of the images below, I will explain what are the actions that this application can do and the features it has:

Flesch Index Button: will allow the user determine the readability of text by displaying a number that is calculated based on the complexity of the text. In short, this means the application will allow the user to measure how hard to read is the text provided. I am pretty sure you(reader) must be wondering how exactly this application is quantifying the difference between text that is hard to read and text that is easy to read. Basically what is used under the hood here is a famous formula called the Flesch Reading Ease Formula, this formula is known for its accuracy to measure the readability of texts in english and has been developed by the author and writing consultant Rudolph Flesch. The formula and table to asses the ease of readability of texts are the following:

<p align="center">
    <img src="https://render.githubusercontent.com/render/math?math=Fleschscore = 206.835 - 1.015(\frac{NumberOfWords}{NumberOfSentences})-84.6(\frac{NumberOfSyllables}{NumberOfWords})" height=40>
</p>

| Score     | School Level                     |
|:---------:|:--------------------------------:|
| 90 to 100 | 5th grade                        | 
| 80 to 90  | 6th grade                        |  
| 70 to 80  | 7th grade                        |
| 60 to 70  | 8th and 9th grade                |
| 50 to 60  | 10th to 12th grade (high school) |
| 30 to 50  | college                          |
| 0 to 30   | college graduate                 |
