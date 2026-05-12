
# Bubble Sort implementation in Python
def bubble_sort(arr):
    n = len(arr)                                    # Get the number of elements in the array
    for i in range(n):                              # Traverse through all array elements           
        for j in range(0, n-i-1):                   # Last i elements are already in place, no need to check them
            if arr[j] > arr[j+1]:                   # Compare adjacent elements
                arr[j], arr[j+1] = arr[j+1], arr[j] # Swap if the element found is greater than the next element
    return arr

# Example usage
if __name__ == "__main__":
    arr = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr = bubble_sort(arr)
    print("Sorted array is:", sorted_arr)
    
    