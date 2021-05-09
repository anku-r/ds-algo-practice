#include <iostream>
using namespace std;

int main()
{
    //initializing input
    int A[6] = {10, 12, 9, 3, 11, 5};

    //performing insertion sort
    for (int i = 1; i < 6; i++)
    {
        int key = A[i];
        int j = i - 1;
        while (j >= 0 && A[j] > key) 
        {
            A[j + 1] = A[j];
            j--;
        }
        A[j + 1] = key;
    }
    
    //printing sorted array
    for (int i = 0; i < 6; i++)
    {
        cout<<A[i]<<endl;
    }
}