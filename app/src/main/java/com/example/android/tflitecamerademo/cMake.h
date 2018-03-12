//
// Created by admin on 3/12/2018.
//

#ifndef TFLITE_CMAKE_H
#define TFLITE_CMAKE_H

#endif //TFLITE_CMAKE_H
cmake_minimum_required(VERSION 3.3 FATAL_ERROR)

add_executable(example example.cpp)

find_package( OpenCV REQUIRED )
include_directories( ${OpenCV_INCLUDE_DIRS} )
target_link_libraries( example ${OpenCV_LIBS})

find_package(TensorflowCC COMPONENTS Shared)
if(TensorflowCC_Shared_FOUND)
  target_link_libraries(example TensorflowCC::Shared)
# fallback to the static library
else()
  find_package(TensorflowCC REQUIRED COMPONENTS Static)
  target_link_libraries(example TensorflowCC::Static)
endif()