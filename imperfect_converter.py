for i in range(1, 10):
        try:
                filename = 'data/chapter' + str(i) + '_present_regular.txt'
                with open(filename, 'r') as f:
                        print("chapter", i)
                        for line in f:
                                ind = line.index('(')
                                inf = line[:ind]
                                first = inf[:-2]
                                ending = inf[-2:]
                                if ending == "ar":
                                        print(inf + "(imperfect)", first+"aba", first+"abas", first+"aba", first+"a'bamos", first+"abais", first+"aban")
                                elif ending == "er" or ending == "ir":
                                        print(inf + "(imperfect)", first+"i'a", first+"i'as", first+"i'a", first+"i'amos", first+"i'ais", first+"i'an")
                                else:
                                        print(inf + "(imperfect)", first+"'a", first+"'as", first+"'a", first+"'amos", first+"'ais", first+"'an")
                print("\n")
        except:
                print("")

for i in range(1, 10):
        try:
                filename = 'data/chapter' + str(i) + '_present_irregular.txt'
                with open(filename, 'r') as f:
                        print("chapter", i)
                        for line in f:
                                ind = line.index('(')
                                inf = line[:ind]
                                first = inf[:-2]
                                ending = inf[-2:]
                                if ending == "ar":
                                        print(inf + "(imperfect)", first+"aba", first+"abas", first+"aba", first+"a'bamos", first+"abais", first+"aban")
                                elif ending == "er" or ending == "ir":
                                        print(inf + "(imperfect)", first+"i'a", first+"i'as", first+"i'a", first+"i'amos", first+"i'ais", first+"i'an")
                                else:
                                        print(inf + "(imperfect)", first+"'a", first+"'as", first+"'a", first+"'amos", first+"'ais", first+"'an")
                print("\n")
        except:
                print("")
