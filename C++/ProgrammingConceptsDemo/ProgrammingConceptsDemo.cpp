#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    // Strings
    string s1("abcd");
    string s2 = "abcd";

    cout << "s1 = " << s1 << endl;
    cout << "s2 = " << s2 << endl;

    // mutable
    s2[0] = 'Z';
    cout << "s2 = " << s2 << endl;
    cout << "length of s2 = " << s2.length() << endl;

    string s3 = "Hello!" \
        " How are you today?";
    cout << s3 << endl;

    // Chars
    char a = 'a', z = 122;
    cout << char(a) << char(z) << endl;

    // from lowercase to uppercase
    cout << char(z + ('A' - 'a')) << endl;

    char z_upper = 90;
    // from uppercase to lowercase
    cout << char(z_upper + ('a' - 'A')) << endl;

    char c1, c2, c3;
    
    // cin >> c1 >> c2 >> c3;
    // cin.get(c1);
    // cin.get(c2);
    // cin.get(c3);

    // cout << c1 << c2 << c3;

    //string bio;
    
    //cout << "Tell us something about yourself: ";
    //getline(cin, bio);
    //getline(cin, bio, '@');

    //cout << "Your bio says: " << bio;


    string bio, total_bio;
    string stopWord = "stop";

     //cout << "Tell us something about yourself: ";
     //while (true) {
     //    getline(cin, bio);

     //    total_bio.append(bio + " ");

     //    transform(bio.begin(), bio.end(), bio.begin(), ::tolower);
     //   transform(stopWord.begin(), stopWord.end(), stopWord.begin(), ::tolower);

     //   if (bio.find(stopWord) != string::npos) {
     //        break;
     //   }
     //}

     //cout << "Your bio says: " << total_bio;

    // Loops
    int x;
    int s = 0;
    while (cin >> x)
        s += x;
    cout << "The sum is: " << s;

}
