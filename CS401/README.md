# Machine Learning Challenge

Supervised learning, 10-dimensional input, binary (0/1) output.

## Data

* `train.txt.gz` is a dataset of 100000 training samples, one/line, with the first 10 numbers constituting the input and the last number the target output.

* `test.txt.gz` is 10000 test cases, one/line, with the ten numbers on each line constituting an input.

* `key.txt.asc` is the 10000 correct labels, one/line, each line consisting of a single character, either `0` or `1`.  This file is encrypted using `gpg --symmetric --armor`, but the key will be distributed later.

## Goal

The goal is generalization.

Please turn in (via Moodle) the following:

* `labels.txt`, a file consisting of your best guess for the 10000 labels for the test cases, one/line, each line consisting of a single character, either `0` or `1`.

* Source code to allow me to train a model and generate `labels.txt`, in a `.tgz` or `.zip` file. This should consist of *just* the source code you wrote, along with instructions for running it, including a list of what software needs to be installed first (e.g., R and various packages, or Octave and various packages, or pytorch, or whatever). Ideally the instructions would be to type `make labels.txt`, but if they’re more complicated that’s okay. The code can assume that `train.txt` and `test.txt` are present (uncompressed).

* A report explaining what you did. This should include your guess (with justification) as to your error rate on the test set. Remember: brevity is the soul of wit.

* For **extra credit**, a file `smarty-pants.txt` explaining why the code name for this dataset was “Hugs and Kisses”.

## FAQ

**Q:** Do we need to submit only a single classifier or we could submit multiple classifiers that are implemented using different algorithms?

**A:** You can submit multiple classifiers but you need to tell me which one is “it”, the one you think will generalize best, and put its predictions in `labels.txt`.  And you should describe what you did in your report.

**Q:** Do we need to code everything from scratch or it is fine if we use the machine learning libraries in python?

**A:** You can use ML libraries and such; you are not required to implement algorithms yourself.
If this makes your code very short, that is fine.

**Q:** Can you push back the deadline?

**A:** Ok, done.

**Q:** Doing full k-way k-fold cross validation is really slow, what should I do so my experiments are fast enough to make some progress?

**A:** Ideas: just do 1-way cross validation, thus making a noisier but much faster estimate. You can also try using a subset of the training set for speed, depending on the algorithm you’re using.

**Q:** Is it okay to use a lot of CPU time?

**A:** Sure, as long as *I’m* not paying your power bill. Be sure to keep track of what you did (like scientists do, with a lab notebook) so you can explain it in the report to impress me.

**Q:** Can I use a cluster, or the cloud?

**A:** Sure.  Note: this is just a supposed-to-be-fun assignment, not a dataset for curing cancer.  So if you’re having fun, and it’s a learning experience, great!  But you don’t *need* to go overboard.

> Those who do not want to imitate anything, produce nothing.  
>                 —Salvador Dali

> Measuring programming progress by lines of code is like measuring aircraft building progress by weight.  
>                 —Bill Gates
