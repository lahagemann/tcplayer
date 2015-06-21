# *-* coding: utf-8 *-*
import nltk
import sys
import os
from nltk.corpus import sentiwordnet as swn

def extract_emotion(argv):
    
    output_directory = sys.argv[1]
    
    with open(sys.argv[2],'r') as infile: 
	filepath = sys.argv[2].split('/')
	filename = filepath[len(filepath)-1]
        with open(output_directory+filename+'.emotion','w') as output:
        
            for line in infile:
                pos_senses = 0
                neg_senses = 0 

                senses = swn.senti_synsets(line.strip())

                for sense in senses:
                    if sense.pos_score() > sense.neg_score():
                        pos_senses += 1
                    elif sense.neg_score() > sense.pos_score():
                        neg_senses += 1

                if pos_senses >= neg_senses:
                    output.write('positive' + '\n')
                else:
                    output.write('negative' + '\n')
                    
        output.close()
    infile.close()

extract_emotion(sys.argv)
                
