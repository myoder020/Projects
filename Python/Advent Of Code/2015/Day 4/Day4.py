import hashlib

#actual secret code for challenge bgvyzdsv
#test code abcdef

santaHashStr = 'bgvyzdsv'
MD5 = hashlib.md5(santaHashStr.encode())
cnt = 0
while MD5.hexdigest()[:6] != '000000':
    
    MD5 = hashlib.md5((santaHashStr+str(cnt)).encode())
    # print(MD5.hexdigest())
    cnt += 1

print(MD5.hexdigest())
print(cnt-1)