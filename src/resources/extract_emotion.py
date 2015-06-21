# *-* coding: utf-8 *-*
import nltk
import sys
import os
from nltk.corpus import sentiwordnet as swn

def extract_emotion(argv):
    
    text_directory = sys.argv[1]
    output_directory = 'data/emotion/'
    
    with open(text_directory+sys.argv[2]+'.txt','r') as infile: 
        with open(output_directory+sys.argv[2]+'.emotion','w') as output:
        
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
                
