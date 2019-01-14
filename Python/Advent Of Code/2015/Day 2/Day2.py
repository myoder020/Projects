with open("2.txt") as f:
    cnt = 0
    sp = 0
    ribbon = 0
    for line in f:
        l, w, h = [int(l.strip()) for l in line.split('x')]
        cnt += (2*l*w) + (2*w*h) + (2*h*l)
        cnt += min((l*w), (w*h), (h*l))
        s1 = int(l+l+w+w)
        s2 = int(w+w+h+h)
        s3 = int(h+h+l+l)
        sP = min(s1, s2, s3)
        ribbon += sP + (l*w*h)
        print(cnt, ribbon, sP, s1, s2, s3)