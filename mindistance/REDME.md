Problem: Given a string of words, find the minimum distance (in terms of word positions) between two given target words.

✅ Key Concepts

Linear scan of the word array
Tracking indices of the last seen positions of each target word
Constant extra space

🧠 Explanation

Split the string by whitespace into a list/array of words.
Iterate over word positions; when you encounter one of the two target words, record its index.
Anytime both indices are valid, compute the difference and update the minimum distance.