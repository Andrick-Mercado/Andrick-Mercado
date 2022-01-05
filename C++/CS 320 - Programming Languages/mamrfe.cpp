#include <iostream>
int sum( int a, int b){ return a + b;}
int main(){
  int x = 0;
  std::cout << sum(x++, ++x) << std::endl;
} 