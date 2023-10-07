#include <stdio.h>

int array[3];

int main(void) {
	int i, j, min, index, temp;
	for(i = 0; i < 3; i++){
		scanf("%d", &array[i]);
	}
	
	for(int i = 0; i < 3; i++){
		min = 1000001;
		for(int j = i; j < 3; j++){
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
	for(i = 0; i < 3; i++){
		printf("%d ", array[i]);
	} 
	
}