README:
=====
For those finding this on GitHub: you only need Conjugation.jar and the data folder. The src folder is unnecessary.
For everyone: read on.

The current working directory line that prints when you boot up the program is important.
Do not ignore it.
The current working directory should ALWAYS be the folder that Conjugation.jar resides in.
This is the same folder that contains the data folder, which has lots of text files within.

On Windows, it probably doesn't matter. The working directory is automagically set when you click on the jar.
On Linux, it probably DOES matter. Clicking on the jar will likely set the working directory to your home directory.
For me, that's /home/sam. This is entirely wrong.
You need to navigate to the jar file using the terminal and run the jar via command line.
This should work.
I don't have a Mac machine to test on, but if the Windows way doesn't work, use the Linux way.

Current support (aka what's in the data files):
- Indicative present, preterit, and imperfect tenses (with separations for irregulars)
- "Mandatos formales" (half of the present subjunctive, with no irregular separation)
- "Mandatos informales" (one part imperative, one part subjunctive present, no irregular separation)
