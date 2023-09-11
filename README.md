Compares Random Sequence of 1 and 0s with a permutation n dimensions long to find its distribution. I find this a great way to visually see randomness of a sample. The software randomly cuts the string into sections and compare them with the permutations of length n.

In this example the sequence 000 comes 17.48% in the data.file times.


"Usage: java -jar permutations -f file.bits -s 3 -i 100000000"

-f filename

-s permutation size

-i number of random iterations over data


====Final=====

111 : 9.67%

110 : 10.83%

011 : 10.92%

101 : 11.40%

001 : 13.00%

100 : 13.07%

010 : 13.62%

000 : 17.48%

=====Identity=====

001 : 12.449%

000 : 12.4606%

010 : 12.4611%

011 : 12.504199999999999%

100 : 12.5072%

110 : 12.5245%

101 : 12.533900000000001%

111 : 12.559500000000002%
