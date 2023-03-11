#include <math.h>

class Solution {
public:
	bool isPerfectSquare(const unsigned long long int n) {
        // base cases
        if (n == 1) return true;
        if (n == 0) return false;
        if (std::pow(2, 2) == n) return true;

        unsigned long long int low = 2;
        unsigned long long int high = n / 2;
        unsigned long long int mid;

        while (high - low > 1) {
            mid = (low + high) / 2;
            auto value = std::pow(mid, 2);
            if (value == n) return true;

            if (value > n) high = mid;
            else low = mid;
        }

        return false;
	}
};
