module.exports = {
   moduleFileExtensions: ['js', 'jsx', 'json', 'vue'],
   transform: {
      '.+\\.(css|styl|less|sass|scss|svg|png|jpg|ttf|woff|woff2)$': 'jest-transform-stub',
      '^.+\\.(js|jsx)?$': 'babel-jest',
      '^.+\\.vue$': 'vue-jest'

   },
   transformIgnorePatterns: ['<rootDir>/node_modules/'],
   moduleNameMapper: {
      '^@/(.*)$': '<rootDir>/src/$1'
   },
   snapshotSerializers: ['jest-serializer-vue'],
   testMatch: [
      '**/tests/unit/**/**/*.spec.(js|jsx|ts|tsx)|**/tests/unit/**/*.spec.(js|jsx|ts|tsx)|**/__tests__/*.(js|jsx|ts|tsx)'
   ],
   testURL: 'http://localhost/'
}
