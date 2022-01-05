#include <iostream>
#include <math.h>

/**
 * This program is a class named guitar
 * which simulates a guitars pitchs frequency
 * depending on which strings and frets are
 * being hold or input
 *  @Andrick Mercado 4/2/2021 
 *  CS320 section 2
 **/

class Guitar
{
    private:
    unsigned char numberOfFrets;
    std::string tuningType;
    int e,A,D,G,B,E;
    public:
    // initializes the guitar to EADGBE tuning and a 21 fret guitar
    Guitar()
    {
        numberOfFrets = 21;
        tuningType = "eADGBE";
        e = 82.41;
        A = 110.00;
        D = 146.80;
        G = 196.00;
        B = 246.90;
        E = 329.60;
    }

    // copy constructor (if the guitar allocates heap memory)
    Guitar(const Guitar& obj)
    {
        numberOfFrets = obj.numberOfFrets;
        tuningType = obj.tuningType;
        e = obj.e;
        A = obj.A;
        D = obj.D;
        G = obj.G;
        B = obj.B;
        E = obj.E;
    }

    // sets the corresponding private field and verifies the input is between 1 and 24
    bool setFretBoardLength(const unsigned char numFrets)
    {
        numberOfFrets = numFrets;
        return (numFrets>=1&&numFrets<=24) ? true : false;
    }

    // Returns the corresponding frequency in Hz for the given string and fret. 
    // Unlike array indices, these use natural numbers, so the low E string shall be 
    // string 1 and the high E string shall be 6
    /** unsigned **/double pitchAt(const unsigned char &stringNumber, const unsigned char &fret)
    {
        double pitch;
        switch(stringNumber)
        {
            case '1':
            pitch = E*pow(2,((fret-'0')/12.0));
            break;
            case '2':
            pitch = B*pow(2,((fret-'0')/12.0));
            break;
            case '3':
            pitch = G*pow(2,((fret-'0')/12.0));
            break;
            case '4':
            pitch = D*pow(2,((fret-'0')/12.0));
            break;
            case '5':
            pitch = A*pow(2,((fret-'0')/12.0));
            break;
            case '6':
            pitch = e*pow(2,((fret-'0')/12.0));
            break;
            default:
            pitch = 0.0;
        }
        return pitch;
    }

    // Given the pitch, the method shall return a std::pair object with the string/fret combination 
    // that comes closest to producing that pitch. There may be multiple solutions. The function 
    // shall return the first it identifies
    std::pair<unsigned char, unsigned char> getStringAndFret( double pitch )
    {
        std::pair<unsigned char, unsigned char> combination ('0','0');
        for(int x=1;x<=6;x++)
            for(int y=1;y<=21;y++)
                if(pitchAt('0'+(unsigned char)x, '0'+(unsigned char)y)>=pitch-2.0 && pitchAt('0'+(unsigned char)x, '0'+(unsigned char)y)<=pitch+2.0)
                {//is true if pitch is two ints away from a combination
                    std::pair<unsigned char, unsigned char> isTrue ('0'+(unsigned char)x,'0'+(unsigned char)y);
                    return isTrue;
                }
        return combination;
    }

    // changes the tuning for an individual string.
     void tuneString(unsigned char& string, const double& pitch )
     {
         switch(string)
         {
             case 'e':
             e = pitch;
             break;
             case 'A':
             A = pitch;
             break;
             case 'D':
             D = pitch;
             break;
             case 'G':
             G = pitch;
             break;
             case 'B':
             B = pitch;
             break;
             case 'E':
             E = pitch;
             break;
             default:
             std::cout<<"MAKE SURE CHAR IS LABELED as one of the following e, A, D, G, B, E."<<std::endl;
         }
     }
};
int main()
{
    Guitar test = Guitar();

    Guitar copyOfTest = Guitar(test);
    bool isWork = test.setFretBoardLength(21);
    std::cout<<"is fret board length acceptable: "<<isWork<<std::endl;

    double pitch = test.pitchAt('5','1');
    std::cout<<"pitch at fret 1 and string 5: "<<pitch<<std::endl;

    std::pair<unsigned char, unsigned char> test2 = test.getStringAndFret(116.541);
    std::cout<<"String : "<<test2.first<<" ,Fret: "<<test2.second<<" at pitch 116.541"<<std::endl;

    char test3 = 'e';
    char test4 = 'A';
    //swapped e and A
    test.tuneString((unsigned char&) test3, 110);
    test.tuneString((unsigned char&) test4, 82);

    std::cout<<"Values after swapping e and A "<<std::endl;
    std::pair<unsigned char, unsigned char> test5 = test.getStringAndFret(116.541);
    std::cout<<"String : "<<test5.first<<" ,Fret: "<<test5.second<<" at pitch 116.541"<<std::endl;
    return 0;
} 