# *-* coding: utf-8 *-*
import nltk
import sys
import string
import re
from nltk.stem import WordNetLemmatizer

def lemmatizer(argv):
	output_directory = 'data/text/'
	wnl = WordNetLemmatizer()

	with open(output_directory+sys.argv[2], 'r') as input_text:
		with open(output_directory+sys.argv[2]+'.lemmatized', 'w') as output_text:
			for line in input_text:
				if(line or not line.isspace()):
					words = re.findall(r"[\w']+|[.,!?;]", line)
					for word in words:
						word = word.lower() 
						lemma = wnl.lemmatize(word.strip())
						output_text.write(lemma + '\n')

		output_text.close()
	input_text.close()

lemmatizer(sys.argv)