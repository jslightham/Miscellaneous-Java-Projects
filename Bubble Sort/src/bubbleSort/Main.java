package bubbleSort;

public class Main {
	public static void main(String[] args) {
		boolean finished = true;
		int[] array = { 7103, 9482, 3869, 3914, 3180, 4413, 9100, 5923, 2581, 3535, 1719, 9320, 748, 5627, 5921,
				6398, 1040, 7862, 7342, 7136, 7775, 2675, 5127, 6922, 4268, 8015, 656, 6779, 453, 856, 4886, 9648, 1158,
				5518, 8338, 9311, 1661, 5252, 8114, 9579, 3085, 3510, 3882, 865, 7964, 7458, 6266, 194, 5340, 6268,
				4663, 5600, 6340, 3306, 5369, 4329, 145, 4260, 4675, 1349, 7933, 8284, 5320, 3756, 1894, 8295, 6724,
				7249, 4028, 833, 1370, 6906, 1708, 2697, 7405, 8082, 6758, 1745, 2317, 237, 1256, 4854, 1476, 1446,
				4178, 8244, 135, 2433, 3603, 2021, 342, 9143, 7185, 4386, 517, 3160, 480, 3335, 8965, 5654, 4577, 9326,
				8723, 9048, 3290, 9229, 5867, 3900, 2543, 9413, 1166, 7493};
		
		int temp;
		while(finished) {
			finished = false;
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					finished = true;
				}	
			}
		}
		System.out.println("done");
		for(int j = 0; j < array.length - 1; j++) {
			System.out.println(array[j]);
		}
	}
}
 