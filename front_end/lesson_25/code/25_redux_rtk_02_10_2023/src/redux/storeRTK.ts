import { configureStore } from "@reduxjs/toolkit";
import counterSlice from "./slices/counterSlice";

export const storeRTK = configureStore({
    reducer: {
        counter: counterSlice
    }
})

export type RootState = ReturnType<typeof storeRTK.getState>;
export type AppDispatch = typeof storeRTK.dispatch