
#Implementacion quick sort en python
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[len(arr) // 2]  # Elegimos el pivote como el elemento del medio
        left = [x for x in arr if x < pivot]  # Elementos menores que el pivote
        middle = [x for x in arr if x == pivot]  # Elementos iguales al pivote
        right = [x for x in arr if x > pivot]  # Elementos mayores que el pivote
        return quick_sort(left) + middle + quick_sort(right)  # Ordenamos recursivamente y concatenamos los resultados
    