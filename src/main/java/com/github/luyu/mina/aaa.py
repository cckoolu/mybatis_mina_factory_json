import json
import numpy as np
import struct

data = {"lu": "luu"}

# print(type(data))
json_data = json.dumps(data)

num = len(json_data)
ree = num.to_bytes(4, byteorder="big", signed=True)
print(ree)
re = bytes([num])
print(len(re))
print(type(json_data))
# tp = np.array(num, dtype="int32")
# print(type(tp))


print(re)


# byteExample1 = bytearray([re])
testResult = struct.unpack('<B', re)
print(testResult)

byteExample2 = bytearray([55])
print(byteExample2)


