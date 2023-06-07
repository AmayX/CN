//SYCOD214
#include<iostream>
#include<vector>
using namespace std;

vector <char> binary_division(int n1, int n2, vector <char> &data, vector <char> const &divisor)
{
	vector <char>::iterator itr=data.begin();
	vector <char> remain, val, temp;
	for(int i=0;i<n2-1;++i,++itr)
		val.push_back(*itr);
	while(itr!=data.end())
	{
		remain.clear();
		val.push_back(*itr);
		if(val[0]=='0')
			for(int i=0;i<n2;++i)
				temp.push_back('0');
		else
			temp=divisor;
		for(int i=1;i<n2;++i)
		{
			if(temp[i]==val[i])
				remain.push_back('0');
			else
				remain.push_back('1');
		}
		++itr;
		val=remain;
		temp.clear();
	}
	return remain;
}

int main()
{
	int n1, n2, flag=0;
	char temp;
	cout<<"\nEnter number of bits in data: ";
	cin>>n1;
	cout<<"\nEnter number of bits in divisor: ";
	cin>>n2;
	vector <char> sender, receiver, divisor, remain, remain2;
	cout<<"\nEnter sender's data: ";
	for(int i=0;i<n1;++i)
	{
		cin>>temp;
		sender.push_back(temp);
	}
	cout<<"\nEnter divisor: ";
	for(int i=0;i<n2;++i)
	{
		cin>>temp;
		divisor.push_back(temp);
	}
	int extra=n2-1;
	for(int i=0;i<extra;++i)
		sender.push_back('0');
	remain=binary_division(n1, n2, sender, divisor);
	cout<<"\nThe remainder is: ";
	for(auto r:remain)
		cout<<r;
	cout<<endl;
	cout<<"\nEnter receiver's data: ";
	for(int i=0;i<n1;++i)
	{
		cin>>temp;
		receiver.push_back(temp);
	}
	for(auto r:remain)
		receiver.push_back(r);
	remain2=binary_division(n1, n2, receiver, divisor);
	for(auto r:remain2)
		if(r=='1')
			flag=1;

	if(flag)
		cout<<"\nData received is corrupted.\n";
	else
		cout<<"\nData received is correct.\n";
	return 0;
}