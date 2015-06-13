# *-* coding: utf-8 *-*
import nltk
import sys
import string
from nltk.stem import WordNetLemmatizer

def lemmatizer(argv):
	output_directory = 'data/text/'
	wnl = WordNetLemmatizer()

	with open(output_directory+sys.argv[1], 'r') as input_text:
		with open(output_directory+sys.argv[1]+'.lemmatized', 'w') as output_text:
			for line in input_text:
				if(line or not line.isspace()):
					for word in line.split(' '):
						word = word.translate(string.maketrans("",""), string.punctuation) 
						lemma = wnl.lemmatize(word.strip())
						output_text.write(lemma + '\n')

		output_text.close()
	input_text.close()

lemmatizer(sys.argv)




						



