vector<string> num(string str)
{
  std::vector<string> ans;
    int n = str.length();
    string left ;
    string right ;
    string mid ;

    if (n % 2) {
        left = str.substr(0, n / 2);
        mid = str[n / 2];
        right = str.substr((n / 2) + 1);
    } else {
        left = str.substr(0, n / 2);
        right = str.substr(n / 2);
    }
    if (n % 2) {
        ans.push_back(left);
        ans.push_back(mid);
        ans.push_back(right);
    } else {
        ans.push_back(left);
        ans.push_back(right);
    }

    return ans;
}
string reverse(string str){
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
        std::swap(str[left], str[right]);
        left++;
        right--;
    }

    return str;
}
bool compareStr(string a, string b){
    int na = a.length();
    int nb = b.length();
    if(na>nb) return true;
    else if(na<nb) return false;

    for(int i = 0; i< na; i++){
        if(a[i]<b[i]) return false;   
    }
    if(a==b) return false;
    return true;
}
string increStr(string& str){
    if(str[str.length()-1]!='9'){
        str[str.length()-1]++;
        return str;
    }
    else{
        int i = str.length()-1;
        while(i>=0 && str[i]=='9'){
            str[i]='0';
            i--;
        }
        if(i==0){
            string temp= "1";
            str =  temp + str;
        }
        else{
            str[i]++;
        }
        return str;
        
    }
}   
string oddCase(string A){
    vector<string> arr = num(A);
    string left = arr[0];
    string mid = arr[1];
    string right = arr[2];
    string revLeft = reverse(left);
    string ans = "";
    if(compareStr(revLeft,right)){
        ans+=left;
        ans+=mid;
        ans+=revLeft;
        return ans;
    }
    else{
        if(mid == "9"){
            mid = "0";
            increStr(left);
            revLeft = reverse(left);
            ans+=left;
            ans+=mid;
            ans+=revLeft;
            return ans;
        }
        else{
            increStr(mid);
            ans+=left;
            ans+=mid;
            ans+=revLeft;
            return ans;
        }
    }
}
string evenCase(string A){
    vector<string> arr = num(A);
    string left = arr[0];
    string right = arr[1];
    string revLeft = reverse(left);
    string ans = "";
    if(revLeft>right){
        // cout<<"Left:"<<left<<endl;
        ans+=left;
        // cout<<"Reversed Left:"<<revLeft<<endl;
        ans+=revLeft;
        return ans;
    }
    else{
        increStr(left);
        revLeft = reverse(left);
        ans+=left;
        ans+=revLeft;
        return ans;
    }
}
string Solution::solve(string A) {
    bool flag = true;
    for(int i = 0 ; i < A.length(); i++){
        if(A[i]!='9'){
            flag = false;
            break;
        }
    }
    if(flag) {
        string ans = "1";
        for(int i = 0; i < A.length()-1; i++){
            ans.push_back('0');
        }
        ans.push_back('1');
        return ans;
    }
    if(A.length()==1){
        int a = stoi(A);
        a++;
        return to_string(a);
    }
    if(A.length()%2==0) return evenCase(A);
    else return oddCase(A);
}
