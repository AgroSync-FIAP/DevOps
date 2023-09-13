/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend:{
      fontSize: {
        '40': '40px',
      },
      lineHeight: {
        '156': '155.99%',
      },
      colors: {
        'creme': 'rgba(250, 246, 241, 1)',
        'green-pastel-light' : 'rgba(174, 193, 182, 1)',
        'green-pastel-dark': 'rgba(122, 153, 135, 1)',
        'text-green': 'rgba(50, 72, 58, 1)',
        'collor-link' : 'rgba(36, 127, 74, 1)',
        'green': 'rgba(201, 216, 208, 1)',
        'cancel': 'rgba(125, 16, 16, 1)',
        'green-pea': {
          '50': '#f2fbf6',
          '100': '#e1f7ea',
          '200': '#c4eed7',
          '300': '#95e0b6',
          '400': '#5fc98f',
          '500': '#39ae6e',
          '600': '#2a8f58',
          '700': '#247148',
          '800': '#21593b',
          '900': '#1d4a33',
          '950': '#0b2819',
      },
      
      },
      backgroundImage: {
        'gradient-radial': 'radial-gradient(var(--tw-gradient-stops))',
        'gradient-conic':
          'conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))',
      },
      backgroundColor: {
        'creme': 'rgba(250, 246, 241, 1)',
        'green-pastel-light' : 'rgba(174, 193, 182, 1)',
        'green-pastel-dark': 'rgba(122, 153, 135, 1)',
        'text-green': 'rgba(50, 72, 58, 1)',
        'collor-link' : 'rgba(36, 127, 74, 1)',
        'green': 'rgba(201, 216, 208, 1)',
        'cancel': 'rgba(125, 16, 16, 1)',
        'green-pea': {
          '50': '#f2fbf6',
          '100': '#e1f7ea',
          '200': '#c4eed7',
          '300': '#95e0b6',
          '400': '#5fc98f',
          '500': '#39ae6e',
          '600': '#2a8f58',
          '700': '#247148',
          '800': '#21593b',
          '900': '#1d4a33',
          '950': '#0b2819',
      },
      },
    },
  },
  plugins: [],
}
