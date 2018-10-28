import unittest
import sys
import os.path

testsObject = unittest.TestLoader().discover('.')

testListFile = ('./testList/testList.txt')
os.makedirs(os.path.dirname(testListFile), exist_ok=True)
sys.stdout = open(testListFile, 'w')
for i in testsObject:
	list = i._tests
	for e in list:
		testsName = e._tests
		for t in testsName:
			print(t)

sys.stdout.close()
