#include <stdio.h>

int array[1001];

int main(void) {
	int number, i, j, min, index, temp;
	scanf("%d", &number);
	for(i = 0; i < number; i++){
		scanf("%d", &array[i]);
	}
	
	for(int i = 0; i < number; i++){
		min = 1001;
		for(int j = i; j < number; j++){
			if(array[j] < min){
				min = array[j];
				index = j;
			}
		}
		
		temp = array[i];
		array[i] = min;
		array[index] = temp;
	}
	
	
	//출력해기 
	for(i = 0; i < number; i++){
		printf("%d\n", array[i]);
	} 
	
}