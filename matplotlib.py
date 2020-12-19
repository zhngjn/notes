import matplotlib as plt
import numpy as np

x = np.linspace(start, end, num)

# standard normal distribution
np.random.randn(100)

plt.plot(x, y, ls="-", lw=2, label="test")
plt.legend()
plt.show()

