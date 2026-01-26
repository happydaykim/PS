def isPalindrome(text):
    l = 0
    r = len(text) - 1

    while l < r:
        if text[l] != text[r]:
            return "no"
        l += 1
        r -= 1
    return "yes"

while True:
    text = input()
    if text == "0": break
    print(isPalindrome(text))