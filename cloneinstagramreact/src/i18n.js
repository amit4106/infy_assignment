import i18n from 'i18next';
import {initReactI18next} from "react-i18next";

i18n.use(initReactI18next).init({
    resources: {
        en: {
            translations: {
                'Sign Up': 'Sign Up',
                'Display Name': 'Display Name',
                'Password': 'Password',
                'Password Repeat': 'Confirm Password',
                'Username':'Username',
                'Login': 'Login'
            }
        }, tr: {
            translations: {
                'Sign Up': 'Kayıt Ol',
                'Display Name': 'Görünen İsim',
                'Password': 'Şifre',
                'Password Repeat': 'Şifre Tekrarı',
                'Username':'Kullanıcı Adı',
                'Login': 'Giriş Yap'
            }
        },
        hn: {
            translations: {
                'Sign Up': 'साइन अप करें',
                'Display Name': 'डिस्प्ले नाम',
                'Password': 'पासवर्ड',
                'Password Repeat': 'पासवर्ड दोहराएं',
                'Username': 'उपयोगकर्ता नाम',
                'Login': 'लॉगिन करें'
            }
        }
    }, fallbackLng: 'tr', ns: ['translations'], defaultNS: 'translations', interpolation: {
        escapeValue: false, formatSeparator: ','
    }, react: {
        wait: true
    }

});

export default i18n;